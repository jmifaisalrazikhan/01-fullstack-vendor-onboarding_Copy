import { defineStore } from 'pinia';
import { ref } from 'vue';
import { VendorService } from '../services/VendorService';
import type { Vendor } from '../types/Vendor';

export const useVendorStore = defineStore('vendor', () => {
  const vendors = ref<Vendor[]>([]);
  const loading = ref(false);
  const error = ref<string | null>(null);
  const vendorFormError = ref<string | null>(null);
  const vendorListError = ref<string | null>(null);
  

  async function fetchVendors() {
    loading.value = true;
    error.value = null;

    try {
      const response = await VendorService.getVendors();
      vendors.value = response.reverse(); // newest first
    } catch (err) {
      error.value = 'Failed to load vendors. Please try again later.';
      console.error('Fetch error:', err);
    } finally {
      loading.value = false;
    }
  }

  async function addVendor(vendor: Vendor) {
    loading.value = true;
    error.value = null;
    vendorFormError.value = null;
    vendorListError.value = null;

    try {
  await VendorService.createVendor(vendor);
  await fetchVendors(); // refresh list
} catch (err: any) {
  const errorMsg = err.message || 'Failed to add vendor. Please try again later.';
  vendorFormError.value = errorMsg;
  vendorListError.value = errorMsg;

  console.error('Add error:', err);
  throw err; // allow form to react
} finally {
  loading.value = false;
}

  
  }

  return {
    vendors,
    loading,
    vendorFormError,
    vendorListError,
    error,
    fetchVendors,
    addVendor
  };
});
